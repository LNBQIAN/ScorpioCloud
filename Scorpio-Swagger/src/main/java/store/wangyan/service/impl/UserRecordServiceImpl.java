package store.wangyan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import store.wangyan.dao.UserRecordDao;
import store.wangyan.entity.UserRecord;
import store.wangyan.service.IUserRecordService;

@Service("userRecordService")
public class UserRecordServiceImpl extends ServiceImpl<UserRecordDao, UserRecord> implements IUserRecordService {

}
