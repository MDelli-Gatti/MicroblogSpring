package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by michaeldelli-gatti on 6/21/16.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
}
