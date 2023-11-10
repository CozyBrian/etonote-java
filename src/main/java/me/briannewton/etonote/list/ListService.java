package me.briannewton.etonote.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
