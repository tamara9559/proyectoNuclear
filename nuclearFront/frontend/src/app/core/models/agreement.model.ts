export interface Agreement {

    id?: number;

    empresaId: number;

    tipoConvenio: string;

    fechaInicio: string;

    fechaFin: string;

    estado: string;

    firmadoEmpresa: boolean;

    firmadoUniversidad: boolean;

    firmadoEstudiante: boolean;

    certificadoCamaraComercio: boolean;

    validado: boolean;

    observaciones: string;

}