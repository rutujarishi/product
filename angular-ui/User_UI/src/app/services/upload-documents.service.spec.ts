import { UploadDocumentsService } from './upload-documents.service';
import { TestBed } from '@angular/core/testing';


describe('UploadDocumentsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UploadDocumentsService = TestBed.get(UploadDocumentsService);
    expect(service).toBeTruthy();
  });
});
