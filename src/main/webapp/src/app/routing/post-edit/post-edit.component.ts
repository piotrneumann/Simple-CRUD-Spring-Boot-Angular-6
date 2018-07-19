import {Component, OnDestroy, OnInit} from '@angular/core';
import {PostData} from "../../shared/interfaces/post-data";
import {ActivatedRoute, Router} from "@angular/router";
import {PostService} from "../../shared/services/post.service";
import {Subscription} from "rxjs/index";
import {AbstractControl, FormGroup, NgForm} from "@angular/forms";

@Component({
  selector: 'app-post-edit',
  templateUrl: './post-edit.component.html',
  styleUrls: ['./post-edit.component.css']
})
export class PostEditComponent implements OnInit, OnDestroy {

  public addPostForm: FormGroup;
  post: PostData = {title: "", description: ""};
  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private postService: PostService,) {

  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.postService.get(id).subscribe((post: PostData) => {
          if (post) {
            this.post = post;
          } else {
            console.log('Post id: ' + id + ' not found, back to list');
            this.goToList();
          }
        })
      }
    })
  }

  goToList() {
    this.router.navigate(['/post-list']);
  }

  save() {
    this.postService.save(this.post).subscribe(result => {
      this.goToList();
    }, error => console.error(error));
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

  remove() {
    const id:string = this.post.id + "";
    this.postService.delete(id).subscribe(result => {
      this.goToList();
    }, error => console.error(error));
  }

  submmitPostForm(): void {
    this.save();
  }

}
