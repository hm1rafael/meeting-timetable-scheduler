package com.github.hm1rafael.reader;

import com.github.hm1rafael.pojo.Meeting;

import java.io.File;
import java.util.List;

/**
 * Created by mattos on 20/02/17.
 */
public interface MeetingsReader {

    List<Meeting> read(File input);

}
