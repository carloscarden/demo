package com.ejemploCompleto.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemploCompleto.demo.modelo.Usuario;


/*
 *      JpaRepository vs CrudRepository
 *      
 * 
 JpaRepository extends PagingAndSortingRepository which in turn extends CrudRepository.
  
  Their main functions are:
          * CrudRepository mainly provides CRUD functions.
          * PagingAndSortingRepository provides methods to do pagination and sorting records.
          * JpaRepository provides some JPA-related methods such as flushing the persistence 
          context and deleting records in a batch.
  Because of the inheritance mentioned above, JpaRepository will have all the functions 
  of CrudRepository and PagingAndSortingRepository. 
  So if you don't need the repository to have the functions provided by JpaRepository 
  and PagingAndSortingRepository , use CrudRepository.

*/
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findByUsername(String username);
	Usuario findByUsuarioId(Long id);
	
	Usuario findByUsernameAndPassword(String username, String password);

}
