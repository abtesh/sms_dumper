package com.anbesabank.sms_db_dumper.Repositories;

import com.anbesabank.sms_db_dumper.RedisModel.RedisSalary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends CrudRepository<RedisSalary, String> {
}
