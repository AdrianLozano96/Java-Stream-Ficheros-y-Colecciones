package org.alozano.model;

import lombok.Builder;
import lombok.Data;

@Data
//@Builder
public class Csv {
    private String estacion_codigo;
    private String zona_calidad_aire_descripcion;
    private String estacion_municipio;
    private String estacion_fecha_alta;
    private String estacion_tipo_area;
    private String estacion_tipo_estacion;
    private String estacion_subarea_rural;
    private String estacion_direccion_postal;
    private String estacion_coord_UTM_ETRS89_x;
    private String estacion_coord_UTM_ETRS89_y;
    private String estacion_coord_longitud;
    private String estacion_coord_latitud;
}
