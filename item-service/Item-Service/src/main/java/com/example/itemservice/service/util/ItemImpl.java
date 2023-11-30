package com.example.itemservice.service.util;

import com.example.itemservice.dto.ItemDto;
import com.example.itemservice.entity.ItemEntity;
import com.example.itemservice.repo.ItemRepo;
import com.example.itemservice.service.ItemService;
import com.example.itemservice.util.Converter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemImpl implements ItemService {
    @Autowired
    ItemRepo repo;
    @Autowired
    Converter converter;

    @Override
    public void Save(ItemDto itemDto) {
        if (repo.existsById(itemDto.getItemId())){
            throw new RuntimeException(itemDto.getItemId()+"Item Not Found");
        }
        repo.save(converter.getUserEntity(itemDto));
    }

    @Override
    public void update(ItemDto itemDto) {
        if(!repo.existsById(itemDto.getItemId())){
            throw new RuntimeException(itemDto+"Item Not Found !");
        }
        repo.save(converter.getUserEntity(itemDto));
    }

    @Override
    public void delete(String id) {
        if (!repo.existsById(id)){
            throw new RuntimeException(id+"Item Not Found !");
        }
        repo.deleteById(id);

    }

    @Override
    public ItemDto findById(String id) {
        Optional<ItemEntity> optionalItemEntity = repo.findById(id);
        if (optionalItemEntity.isEmpty())
            throw  new RuntimeException("Item not Found !");
        return converter.getUserDTO(optionalItemEntity.get());
    }

    @Override
    public List<ItemDto> getAll() {
        List<ItemDto> itemDtos = new ArrayList<>();
        List<ItemEntity> itemEntities = repo.findAll();
        for (ItemEntity item: itemEntities) {
            ItemDto dto = converter.getUserDTO(item);
            itemDtos.add(dto);
        }
        return itemDtos;
    }
}
