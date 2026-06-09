export interface Vacancy {

    id?: number;

    empresaId: number;

    titulo: string;

    descripcion: string;

    perfilRequerido: string;

    habilidadesRequeridas: string;

    carreraRequerida: string;

    tipoVacante: string;

    modalidad: string;

    ciudad: string;

    remuneracion: number;

    cupos: number;

    estado: string;

    fechaPublicacion: string;

    fechaCierre: string;

}