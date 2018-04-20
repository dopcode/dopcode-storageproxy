package org.dopcode.storageproxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import destiny.service.common.file.XFile;
import destiny.service.common.version.XCheckOut;
import destiny.service.edm.folder.XFolder;

@RestController
public class StorageProxyRestController {

    @GetMapping("/")
    public String index() {
        return "hello! dopcode StorageProxy Server~";
    }
    
    @GetMapping("/get/{id}")
    public String index(@PathVariable("id") Long id) {
        return "hello! dopcode StorageProxy Server~ get id: " + id;
    }
    
    @PatchMapping("/fileCheckout/{id}")
    public ResponseEntity<List<XCheckOut>> fileCheckout(@PathVariable("id") Long id) {
        List<XCheckOut> checkOuts = new ArrayList<XCheckOut>();
        XCheckOut checkOut = new XCheckOut();
        checkOuts.add(checkOut);
        if (checkOuts.isEmpty()) {
            return new ResponseEntity<List<XCheckOut>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<XCheckOut>>(checkOuts, HttpStatus.OK);
    }

    @PatchMapping("/fileCheckin/{id}")
    public ResponseEntity<XCheckOut> fileCheckin(@PathVariable("id") Long id) {
        XCheckOut checkOut = new XCheckOut();
        if (checkOut == null) {
            return new ResponseEntity<XCheckOut>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<XCheckOut>(checkOut, HttpStatus.OK);
    }

    @GetMapping("/fileDownload/{id}")
    public ResponseEntity<XFile> fileDownload(@PathVariable("id") Long id) {
        XFile file = new XFile();
        if (file == null) {
            return new ResponseEntity<XFile>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<XFile>(file, HttpStatus.OK);
    }

    @PostMapping("/fileUpload")
    public ResponseEntity<XFile> fileUpload(@RequestBody XFile file) {
        if (file == null) {
            return new ResponseEntity<XFile>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<XFile>(file, HttpStatus.OK);
    }

    @PatchMapping("/fileLock/{id}")
    public ResponseEntity<XCheckOut> fileLock(@PathVariable("id") Long id) {
        XCheckOut checkOut = new XCheckOut();
        if (checkOut == null) {
            return new ResponseEntity<XCheckOut>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<XCheckOut>(checkOut, HttpStatus.OK);
    }

    @PatchMapping("/fileUnlock/{id}")
    public ResponseEntity<XCheckOut> fileUnlock(@PathVariable("id") Long id) {
        XCheckOut checkOut = new XCheckOut();
        if (checkOut == null) {
            return new ResponseEntity<XCheckOut>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<XCheckOut>(checkOut, HttpStatus.OK);
    }

    @PatchMapping("/fileRename/{id}")
    public ResponseEntity<XFile> fileRename(@PathVariable("id") Long id, @RequestBody XFile file) {
        if (file == null) {
            return new ResponseEntity<XFile>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<XFile>(file, HttpStatus.OK);
    }

    @PatchMapping("/fileMove/{id}")
    public ResponseEntity<XFile> fileMove(@PathVariable("id") Long id, @RequestBody XFile file) {
        if (file == null) {
            return new ResponseEntity<XFile>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<XFile>(file, HttpStatus.OK);
    }

    @RequestMapping("/folderCreate")
    public ResponseEntity<XFolder> folderCreate(@RequestBody XFolder folder) {
        if (folder == null) {
            return new ResponseEntity<XFolder>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<XFolder>(folder, HttpStatus.OK);
    }

    @PatchMapping("/folderRename/{id}")
    public ResponseEntity<XFolder> folderRename(@PathVariable("id") Long id, @RequestBody XFolder folder) {
        if (folder == null) {
            return new ResponseEntity<XFolder>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<XFolder>(folder, HttpStatus.OK);
    }

    @RequestMapping("/folderMove/{id}")
    public ResponseEntity<XFolder> folderMove(@PathVariable("id") Long id, @RequestBody XFolder folder) {
        if (folder == null) {
            return new ResponseEntity<XFolder>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<XFolder>(folder, HttpStatus.OK);
    }
}
