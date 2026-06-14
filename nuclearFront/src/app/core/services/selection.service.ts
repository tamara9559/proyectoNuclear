import {
inject,
Injectable
} from '@angular/core';

import {
HttpClient
} from '@angular/common/http';

@Injectable({

providedIn:
'root'

})

export class SelectionService {

private http =
inject(
HttpClient
);

private api =
'http://localhost:8080/api/selections';

sendResume(
studentId:number,
vacancyId:number
){

return this.http.post(

`${this.api}/send-resume?studentId=${studentId}&vacancyId=${vacancyId}`,

{}

);

}

accept(
studentId:number,
vacancyId:number
){

return this.http.put(

`${this.api}/accept?studentId=${studentId}&vacancyId=${vacancyId}`,

{}

);

}

reject(
studentId:number,
vacancyId:number
){

return this.http.put(

`${this.api}/reject?studentId=${studentId}&vacancyId=${vacancyId}`,

{}

);

}

finalize(
studentId:number,
vacancyId:number
){

return this.http.put(

`${this.api}/finalize?studentId=${studentId}&vacancyId=${vacancyId}`,

{}

);

}

}