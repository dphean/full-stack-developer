import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map } from 'rxjs/operators';
import { retry, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SuperisorService {

  // http://localhost:8080/api/supervisor
  private supervisor_api_url: string = 'http://localhost:8080/api';

  constructor(private httpClient: HttpClient) { }

  getSuperisor(): Observable<any> {
    return this.httpClient
    .get(this.supervisor_api_url + '/supervisor')
    //.toPromise().then(data => );
    //.pipe(retry(1), catchError(this.throwError));
  }

  throwError(error: any): any {
    console.error(error);
    throw new Error('Method not implemented.');
  }
}

