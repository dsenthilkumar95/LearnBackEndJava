package com.improve.springdatajpa;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserWithCompositeKeyService {
    @Autowired
    private UserWithCompositeKeyRepository userWithCompositeKeyRepository;

    UserWithCompositeKeyMapper mapper = Mappers.getMapper(UserWithCompositeKeyMapper.class);

    public UserWithCompositeKeyDTO createNewUser(UserWithCompositeKeyDTO userWithCompositeKeyDto){
        System.out.println("UserWithCompositeKeyDTO -> " + userWithCompositeKeyDto.toString());
        UserWithCompositeKey userWithCompositeKey = mapper.dtoToPojo(userWithCompositeKeyDto);
        System.out.println("userWithCompositeKey before -> " + userWithCompositeKey);
        userWithCompositeKey = userWithCompositeKeyRepository.save(userWithCompositeKey);
        System.out.println("userWithCompositeKey after -> " + userWithCompositeKey);
        return  mapper.pojoToDto(userWithCompositeKey);

    }

    public List<UserWithCompositeKey> getAllUserWithCompositeKey(){
        List<UserWithCompositeKey> userWithCompositeKeyList = new ArrayList<>();
        Iterator<UserWithCompositeKey> userWithCompositeKeyIterator = userWithCompositeKeyRepository.findAll().iterator();
        while(userWithCompositeKeyIterator.hasNext()){
            userWithCompositeKeyList.add(userWithCompositeKeyIterator.next());
        }
        return userWithCompositeKeyList;
    }

}
