package me.briannewton.etonote.service;

import java.util.Optional;

import me.briannewton.etonote.model.List;
import me.briannewton.etonote.model.DTOs.ListDTO;

public interface ListService {
  public Optional<List> getList(String listId);

  public java.util.List<ListDTO> getUserLists(String userId);

  public List addList(List list);

  public List updateList(String listID, List list);

  public java.util.List<ListDTO> getAllLists();
}
