package me.briannewton.etonote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.briannewton.etonote.model.List;
import me.briannewton.etonote.repository.ListRepository;

@Service
public class ListService {
  private final ListRepository listRepository;

  @Autowired
  public ListService(ListRepository listRepository) {
    this.listRepository = listRepository;
  }

  public java.util.List<List> getLists() {
    return listRepository.findAll();
  }

  public List addList(List list) {
    return listRepository.save(list);
  }
}
