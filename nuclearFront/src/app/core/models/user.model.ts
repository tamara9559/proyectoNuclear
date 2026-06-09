export interface User {

    id?: number;

    nombres: string;

    apellidos: string;

    correo: string;

    password?: string;

    telefono: string;

    rol: string;

    estado: boolean;

    fechaCreacion?: string;

    ultimoAcceso?: string;

}