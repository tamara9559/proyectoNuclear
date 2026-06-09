export interface Practice {

    id?: number;

    estudianteId: number;

    empresaId: number;

    vacanteId: number;

    convenioId: number;

    ciudad: string;

    tutorEmpresarial: string;

    correoTutor: string;

    tipoContrato: string;

    fechaInicio: string;

    fechaFin: string;

    duracionSemanas: number;

    estado: string;

    requiereMovilidad: boolean;

    observaciones: string;

}