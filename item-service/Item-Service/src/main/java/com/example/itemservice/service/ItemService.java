package com.example.itemservice.service;

import com.example.itemservice.dto.ItemDto;

import java.util.List;

public interface ItemService {
    public void Save(ItemDto itemDto);
    public void update(ItemDto itemDto);
    public void  delete(String id);
    ItemDto findById(String id);
    List<ItemDto> getAll();

}
