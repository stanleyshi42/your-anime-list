import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class JikanService {
  private uri = 'https://api.jikan.moe/v4/';

  constructor(private http: HttpClient) {}

  // Get anime by MAL ID
  getById(id: string): Observable<any> {
    return this.http.get<any>(this.uri + 'anime/' + id);
  }

  // Get list of top anime
  getTop(): Observable<any> {
    return this.http.get<any>(this.uri + 'top/anime');
  }

  // Get list of currently airing anime
  getAiring(): Observable<any> {
    return this.http.get<any>(this.uri + 'seasons/now?sfw');
  }

  getUpcoming(): Observable<any> {
    return this.http.get<any>(this.uri + 'seasons/upcoming?sfw');
  }

  searchByName(name: string): Observable<any> {
    return this.http.get<any>(this.uri + 'anime?q=' + name);
  }
}
