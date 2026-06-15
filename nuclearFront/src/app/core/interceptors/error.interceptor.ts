import {

HttpInterceptorFn

}

from
'@angular/common/http';

import {

inject

}

from
'@angular/core';

import {

Router

}

from
'@angular/router';

import {

catchError

}

from
'rxjs';

import {

throwError

}

from
'rxjs';

export const errorInterceptor:

HttpInterceptorFn=(

req,
next

)=>{

const router=

inject(
Router
);

return next(

req

)

.pipe(

catchError(

err=>{

if(
err.status===401
){

router.navigate(

[
'/unauthorized'
]

);

}

if(
err.status===403
){

router.navigate(

[
'/forbidden'
]

);

}

return throwError(
()=>err
);

}

)

);

};