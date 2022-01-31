package com.mouritech.employee.util;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;

public class HibernateUtil {

       private static StandardServiceRegistry registry;
		private static SessionFactory sessionFactory;
		
		public static SessionFactory getSessionFactory() {
			if(sessionFactory ==  null) {
				try {
					//create registry
					registry = new StandardServiceRegistryBuilder().configure().build();
					//create Metadata Sources
					MetadataSources sources = new MetadataSources(registry) ;
					//create Metadata
					Metadata metadata = sources.getMetadataBuilder().build();
					//create SessionFactory		
					sessionFactory = metadata.getSessionFactoryBuilder().build();
							
					
				}catch (Exception e) {
					e.printStackTrace();
					if(registry != null) {
						StandardServiceRegistryBuilder.destroy(registry);
					}
				}
			}
			return sessionFactory;
		}

		public static SessionFactory getSessionFactory1() {
			// TODO Auto-generated method stub
			return null;
		}
		

}