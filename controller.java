package com.example.demo.web;

import com.example.demo.Application.main;
import com.example.demo.core.NotificationTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class controller {
    private main service=new main();
    @PostMapping("/api/template/add")
    public void  add(@RequestBody NotificationTemplate temp) throws SQLException {

       service.add(temp);


    }
    @GetMapping("/api/template/read")
    public NotificationTemplate get(@RequestParam String id)
    {
        int i=Integer.parseInt(id);
        return service.read(i);
    }
    @PutMapping("/api/template/update")
    public void update(@RequestBody NotificationTemplate temp)
    {
        service.update(temp);
    }
    @DeleteMapping("/api/template/delete")
    public void  delete(@RequestParam String id)
    {
        int i=Integer.parseInt(id);

        service.delete(i);
    }
}
