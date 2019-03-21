/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Date;
import java.util.List;
import models.Overtime;

/**
 *
 * @author milhamafemi
 */
public interface OvertimeControllerInterface {

    public String insert(String id, Date overtimeDate, String timeDuration, String keterangan, String timeSheet, String status, byte[] signature);
    public String insert2(String id, Date overtimeDate, String timeDuration, String keterangan, String timeSheet, String status);

    public String update(String id, Date overtimeDate, String timeDuration, String keterangan, String timeSheet, String status);

    public String delete(String id);

    public Overtime getById(String id);

    public List<Overtime> getData(String key);

    public List<Overtime> getAll();

    public List<Overtime> getByMang(String key);

    public List<Overtime> empOvertime(String id);

    public Long totOver(String id);

    public List<Overtime> history(String id);

}
