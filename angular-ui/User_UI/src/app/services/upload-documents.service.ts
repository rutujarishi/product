import { environment } from '../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../util';
@Injectable({
  providedIn: 'root'
})
export class UploadDocumentsService {
  // private url = 'http://localhost:8083/api/v1/saveUserProfile';
  private url = environment.uploadDocumentURL + '/api/v1/saveUserProfile';
  constructor(public http: HttpClient) {
    this.http = http;
  }
  saveUser(formData: FormData) {
    console.log(formData);
    return this.http.post(this.url, formData, { responseType: 'text' });
  }
}
