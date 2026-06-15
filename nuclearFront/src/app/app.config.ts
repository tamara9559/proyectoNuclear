import {
ApplicationConfig,
provideBrowserGlobalErrorListeners
} from '@angular/core';

import {
provideRouter
} from '@angular/router';

import {
provideHttpClient
} from '@angular/common/http';

import {
routes
} from './app.routes';

import {
withInterceptors
}
from '@angular/common/http';

import {
errorInterceptor
}
from './core/interceptors/error.interceptor';

import {
loadingInterceptor
}
from './core/interceptors/loading.interceptor';

import {
  authInterceptor
}
from './core/interceptors/auth.interceptor';

export const appConfig: ApplicationConfig = {

providers: [

provideBrowserGlobalErrorListeners(),

provideRouter(routes),

provideHttpClient(

withInterceptors([
    loadingInterceptor,
errorInterceptor,
authInterceptor
])
)


]



};