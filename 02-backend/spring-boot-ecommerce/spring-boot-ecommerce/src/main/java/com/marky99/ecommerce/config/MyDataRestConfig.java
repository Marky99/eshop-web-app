package com.marky99.ecommerce.config;

import com.marky99.ecommerce.entity.Country;
import com.marky99.ecommerce.entity.Product;
import com.marky99.ecommerce.entity.ProductCategory;
import com.marky99.ecommerce.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.ExposureConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unsuportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        disableHttpMethods(config.getExposureConfiguration()
                .forDomainType(Product.class), unsuportedActions);

        disableHttpMethods(config.getExposureConfiguration()
                .forDomainType(ProductCategory.class), unsuportedActions);

        disableHttpMethods(config.getExposureConfiguration()
                .forDomainType(Country.class), unsuportedActions);

        disableHttpMethods(config.getExposureConfiguration()
                .forDomainType(Region.class), unsuportedActions);

        exposeIds(config);
    }

    private void disableHttpMethods(ExposureConfigurer config, HttpMethod[] unsuportedActions) {
        config
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(unsuportedActions))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(unsuportedActions)));
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        List<Class> entityClasses = new ArrayList<>();

        for(EntityType entityType : entities) {
            entityClasses.add(entityType.getJavaType());
        }

        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }
}
