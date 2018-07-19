import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {PostData} from "../interfaces/post-data";

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http : HttpClient) { }

  getAll(): Observable<PostData[]> {
    return this.http.get<PostData[]>('/api/posts');
  }

  get(id: string) {
    return this.http.get('/api/posts/' + id);
  }

  save(post: PostData): Observable<PostData> {
    console.log(post)
    return this.http.post<PostData>('/api/posts', post);
  }

  edit(post: PostData): Observable<PostData> {
    return this.http.put<PostData>('/api/posts', post);
  }

  delete(id: string) {
    return this.http.delete('/api/posts/' + id);
  }
}
