package com.enterprisebank.banking.infrastructure.persistence.mapper;

import com.enterprisebank.banking.domain.model.*;
import com.enterprisebank.banking.infrastructure.persistence.entity.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersistenceMapper {
    User toDomain(UserEntity entity);
    UserEntity toEntity(User user);
    RefreshToken toDomain(RefreshTokenEntity entity);
    RefreshTokenEntity toEntity(RefreshToken token);
    Customer toDomain(CustomerEntity entity);
    CustomerEntity toEntity(Customer customer);
    BankAccount toDomain(BankAccountEntity entity);
    BankAccountEntity toEntity(BankAccount account);
    BankTransaction toDomain(BankTransactionEntity entity);
    BankTransactionEntity toEntity(BankTransaction transaction);
    AuditLog toDomain(AuditLogEntity entity);
    AuditLogEntity toEntity(AuditLog auditLog);
}
