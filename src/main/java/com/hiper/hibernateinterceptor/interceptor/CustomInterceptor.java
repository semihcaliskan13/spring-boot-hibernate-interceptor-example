package com.hiper.hibernateinterceptor.interceptor;

import com.hiper.hibernateinterceptor.entity.Team;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Interceptor;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Iterator;

@Slf4j
@Component
public class CustomInterceptor implements Interceptor {


    @Override
    public boolean onSave(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {

        if (entity instanceof Team) {
            log.info(((Team) entity).toString() + "entity now is not created in the database.");
        }
        return Interceptor.super.onSave(entity, id, state, propertyNames, types);
    }

    @Override
    public void postFlush(Iterator<Object> entities) throws CallbackException {
        if (entities.hasNext()) {
            Object entity = entities.next();
            if (entity instanceof Team) {
                log.info(((Team) entity).toString() + "entity is created in the database.");
            }
        }

        Interceptor.super.postFlush(entities);
    }

    @Override
    public void onDelete(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {

        if (entity instanceof Team) {
            log.info(((Team) entity).toString() + "entity is not deleted yet.");
        }
        Interceptor.super.onDelete(entity, id, state, propertyNames, types);
    }
}
