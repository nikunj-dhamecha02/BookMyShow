package com.booking;

import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.AudioFileFormat;


class Show {

  private long showId;
  private final Auditorium auditorium;

  public Show(long showId, Auditorium auditorium) {
    this.showId = showId;
    this.auditorium = auditorium;
  }

  public Auditorium getAuditorium() {
    return auditorium;
  }

  public long getShowId(){
    return showId;
  }


}

