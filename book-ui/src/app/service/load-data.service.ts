import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../beans/Book';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { environment } from 'src/environments/environment';
import { Edit } from '../beans/Edit';

@Injectable({
  providedIn: 'root'
})
export class LoadDataService {

  constructor(private http: HttpClient) { }


  listBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(environment.urlListBooks);
  }

  getBook(id: number): Observable<Edit> {
    return this.http.get<Edit>(environment.urlGetBooks.replace(':id',String(id)));
  }

}
