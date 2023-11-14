package me.briannewton.etonote.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import me.briannewton.etonote.model.List;
import me.briannewton.etonote.repository.ListRepository;
import me.briannewton.etonote.service.ListService;

@Service
public class ListServiceImpl implements ListService{
    private final ListRepository listRepository;

  @Autowired
  public ListServiceImpl(ListRepository listRepository) {
    this.listRepository = listRepository;
  }

  @Override
  public Optional<List> getList(String listId) {
    return listRepository.findById(listId);
  }

  @Override
  public java.util.List<List> getUserLists(String userId) {
    return listRepository.findByUserId(userId);
  }

  @Override
  public List addList(List list) {
    return listRepository.save(list);
  }
  
  @Override
  @Transactional
  public List updateList(String listID, List list) {
    List existingList = listRepository.findById(listID)
    .orElseThrow(() -> new IllegalStateException("List with id " + list.getId() + " does not exist"));

    if (list.getTitle() != null && list.getTitle().length() > 0 && !list.getTitle().equals(existingList.getTitle())) {
      existingList.setTitle(list.getTitle());
    }

    if (list.getIcon() != null && !list.getIcon().equals(existingList.getIcon())) {
      existingList.setIcon(list.getIcon());
    }

    return listRepository.save(list);
  }
}
