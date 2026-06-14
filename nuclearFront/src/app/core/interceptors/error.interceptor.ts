import {
HttpErrorResponse,
HttpInterceptorFn
}
from '@angular/common/http';

import {
catchError
} from 'rxjs/operators';

import {
throwError
} from 'rxjs';

import {
inject
}
from '@angular/core';

import {
NotificationService
}
from '../services/notification.service';

export const errorInterceptor:
HttpInterceptorFn = (

req,
next

) => {

return next(
req
).pipe(

catchError(

(
error:
HttpErrorResponse
) => {

let message =
'Error inesperado';

if (
error.status === 0
) {

message =
'No se pudo conectar al servidor';

}

else if (
error.status === 400
) {

message =
'Datos inválidos';

}

else if (
error.status === 401
) {

message =
'No autorizado';

}

else if (
error.status === 403
) {

message =
'Acceso denegado';

}

else if (
error.status === 404
) {

message =
'Recurso no encontrado';

}

else if (
error.status === 500
) {

message =
'Error interno del servidor';

}

const notification =
inject(
NotificationService
);

notification.error(
message
);

return throwError(
() =>
error
);

}

)

);

};