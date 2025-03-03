package com.booking;

import java.util.List;

public class ShowService {

  public List<Show> shows;

  public ShowService(List<Show> shows) {
    this.shows = shows;
  }

  public Show getShowById(long id) {
    return shows.stream().filter(x -> x.getShowId() == id).findFirst().orElse(null);
  }

}
