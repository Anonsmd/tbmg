package com.zstu.tbmg.service.Impl;

import com.zstu.tbmg.dto.CustomerListDTO;
import com.zstu.tbmg.dto.OrderMasterListDTO;
import com.zstu.tbmg.mapper.db1.ManagerLoginMapper;
import com.zstu.tbmg.mapper.db2.CustomerMasterMapper;
import com.zstu.tbmg.pojo.CustomerMaster;
import com.zstu.tbmg.pojo.CustomerMasterExample;
import com.zstu.tbmg.pojo.OrderSmall;
import com.zstu.tbmg.pojo.OrderSmallExample;
import com.zstu.tbmg.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/8 14:21
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMasterMapper customerMasterMapper;
    @Autowired
    private ManagerLoginMapper managerLoginMapper;
    @Override
    public CustomerListDTO getList(int pageNum, int pageSize, String customerName) {
        CustomerMasterExample customerMasterExample = new CustomerMasterExample();
        CustomerMasterExample.Criteria criteria = customerMasterExample.createCriteria();
        if (customerName!=null && customerName.length()>0){
            criteria.andCustomerNameLike('%'+customerName+'%');
        }
        List<CustomerMaster> answList = new ArrayList<>();
        answList = customerMasterMapper.selectByExample(customerMasterExample);
        int total = answList.size();
        CustomerListDTO answ = new CustomerListDTO();
        if (total<=pageSize){
            answ.setList(answList);
        }
        else{
            if ((pageNum-1)*pageSize+pageSize<total){
                answ.setList(answList.subList((pageNum - 1) * pageSize, (pageNum - 1) * pageSize + pageSize));
            }
            else{
                answ.setList(answList.subList((pageNum - 1) * pageSize,total));
            }

        }
        answ.setPageNum(pageNum);
        answ.setPageSize(pageSize);
        answ.setTotal(total);
        answ.setTotalPage((total+pageSize-1)/pageSize);
        return answ;
    }

    @Override
    @Transactional
    public boolean updateStatus(List<Integer> ids) throws Exception {
        for (int i=0;i<ids.size();i++){
            managerLoginMapper.updateCustomerStatus(ids.get(i));
        }
        return true;
    }
}
