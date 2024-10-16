package com.anbesabank.sms_db_dumper.Repositories;

import com.anbesabank.sms_db_dumper.RedisModel.RedisDeposit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends CrudRepository<RedisDeposit, String> {
}
