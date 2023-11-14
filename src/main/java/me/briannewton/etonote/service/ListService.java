package me.briannewton.etonote.service;

import java.util.Optional;

import me.briannewton.etonote.model.List;

public interface ListService {
  public Optional<List> getList(String listId);

  public java.util.List<List> getUserLists(String userId);

  public List addList(List list);

  public List updateList(String listID, List list);
}
