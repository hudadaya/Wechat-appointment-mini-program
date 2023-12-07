package com.example.demo.service.serviceimpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.BlackEntity;
import com.example.demo.entity.BlackUserDto;
import com.example.demo.mapper.BlackEntityMapper;
import com.example.demo.mapper.UsersEntityMapper;
import com.example.demo.service.InsertBlackListService;
import com.example.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertBlackListServiceImpl extends ServiceImpl<BlackEntityMapper, BlackEntity> implements InsertBlackListService {
    @Autowired(required = false)
    private BlackEntityMapper blackEntityMapper;
    @Autowired(required = false)
    private UsersEntityMapper usersEntityMapper;
    @Override
    public Result insertBlackList(String username,String reason) {
        Result result=new Result();
        if(usersEntityMapper.selectByUserName(username)!=null)
        {//存在该系统用户
            if(blackEntityMapper.selectUserInBlack(username)==0)
            {   //code:210 users表存在该用户，且该用户还未加入黑名单
                blackEntityMapper.insertBlackList(username,reason);
                System.out.println("");
                result.setCode("210");
                result.setMsg("成功添加"+username+"至黑名单记录");
            }
            else //code:451 用户已存在黑名单
            {
                result.setCode("451");
                result.setMsg("添加失败: "+username+"已存在黑名单中，请勿重复操作");
            }
        }
        else //code:450 不存在用户，错误用户名
        {
            result.setCode("450");
            result.setMsg("添加失败："+username+"非系统用户，请检查输入信息");
        }
        return result;
    }
}
