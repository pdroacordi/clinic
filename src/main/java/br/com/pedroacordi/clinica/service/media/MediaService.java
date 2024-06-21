package br.com.pedroacordi.clinica.service.media;

import br.com.pedroacordi.clinica.dao.MediaDAO;
import br.com.pedroacordi.clinica.model.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MediaService implements IMediaService{

    @Autowired
    MediaDAO dao;

    @Override
    public Media create(Media media) {
        return dao.save(media);
    }

    @Override
    public Media update(Media media) {
        Media tmp = dao.findById(media.getId()).orElse(null);
        if(tmp == null)
            return null;

        if(media.getName() != null)
            tmp.setName( media.getName() );
        if(media.getLink() != null)
            tmp.setLink( media.getLink() );


        return dao.save(tmp);
    }

    @Override
    public boolean delete(Integer id) {
        if( !dao.existsById(id) )
            return false;
        dao.deleteById(id);
        return true;
    }

    @Override
    public Media getById(Integer id) {
        return dao.findById(id).orElse(null);
    }
}
