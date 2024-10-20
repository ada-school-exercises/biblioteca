package org.ada.biblioteca.repository.mongo.role;

import org.ada.biblioteca.bo.mongo.RoleMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepositoryNoSql extends MongoRepository<RoleMongo, String> {
}
