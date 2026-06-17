import {
inject,
Injectable
} from '@angular/core';

import {
HttpClient
} from '@angular/common/http';

import {
Observable
} from 'rxjs';

import {
CandidateMatch
} from '../models/candidate-match.model';

@Injectable({

providedIn:
'root'

})

export class MatchingService {

private http =
inject(
HttpClient
);

private api =
'http://zealous-emotion-production-bfb7.up.railway.app/api/matching';

ranking(
vacancyId: number
): Observable<CandidateMatch[]> {

return this.http.get<CandidateMatch[]>(

`${this.api}/ranking-score/${vacancyId}`

);

}

}