package com.example.courseproject.Database.sessionFacctory;


import com.example.courseproject.Database.entity.*;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

@NoArgsConstructor
public class SessionFactoryImpl {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Company.class);
                configuration.addAnnotatedClass(AnnualData.class);
                configuration.addAnnotatedClass(LiquidityRatio.class);
                configuration.addAnnotatedClass(MarketIndicators.class);
                configuration.addAnnotatedClass(Profitability.class);
                configuration.addAnnotatedClass(OperationalAnalysis.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
