package edu.ucam.servicios;

import java.util.List;

public interface AdminService {

	public <Entidad> boolean create(Class<Entidad> clase, Object objeto);
	public <Entidad> boolean update(Class<Entidad> clase, Object objeto);
	public <Entidad> boolean delete(Class<Entidad> clase, Object id);
	public <Entidad> List<Entidad> search(String entidad, String where);
	public <Entidad> List<Entidad> search(String entidad, String where, int limit_ini, int limit_fin);
	public <Entidad> List<Entidad> getListado(String entidad);
	public <Entidad> Entidad getRegistroById(Class<Entidad> entidad, Object identificador);
	public <Entidad> List<Entidad> getRegistroByField(String entidad, String campo, Object valor);
	public <Entidad> List<Entidad> getLineasByCabecera(String entidadLineas, String columnaJoin, Object identificador);
	public int getTotalElementosSearch(String entidad, String where);
	public int getTotalElementosListado(String entidad);
}
