package br.com.pedroacordi.clinica.service.media;

import br.com.pedroacordi.clinica.model.Media;

public interface IMediaService {

    public Media create(Media media);
    public Media update(Media media);

    public boolean delete(Integer id);

    public Media getById(Integer id);
}
