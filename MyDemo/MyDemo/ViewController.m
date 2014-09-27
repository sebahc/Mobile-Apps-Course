//
//  ViewController.m
//  MyDemo
//
//  Created by sebahc on 9/24/14.
//  Copyright (c) 2014 Sebastian J Herrera Cano. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()
@property (strong, nonatomic) NSURLSession *session;
@property (strong, nonatomic) NSURLSessionConfiguration *sessionConfiguration;

@end

@implementation ViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
   
    self.menuItems= [[NSMutableArray alloc] init];
    NSURL *url =[NSURL URLWithString:@"http://latamcode.com/clothing/cms/Lib.php?cmd=cms_listado_shirt"];
    NSURLRequest *request = [NSURLRequest requestWithURL:url];
    
    self.sessionConfiguration=[NSURLSessionConfiguration defaultSessionConfiguration];
    self.session=[NSURLSession sessionWithConfiguration:self.sessionConfiguration];
    
    NSURLSessionDataTask *task =[self.session dataTaskWithRequest:request completionHandler:^(NSData *data, NSURLResponse *response, NSError *error) {
        NSHTTPURLResponse *urlResponse = (NSHTTPURLResponse*) response;
        if (urlResponse.statusCode==200){
            NSLog(@"todo joya");
            //sNSLog(@"%@", data);
            [self handleResults:data];
        }
       
    }];
    [task resume];
}

-(void)handleResults:(NSData *)data
{
    NSError *jsonError;
    NSDictionary *response = [NSJSONSerialization JSONObjectWithData:data options:NSJSONReadingAllowFragments error:&jsonError];
    
    NSLog(@"esto es data: %@", response);
    
    
    if (response) {
        
        for (NSDictionary *dataDictionary in response[@"data"]) {
            NSLog(@"probando");
            [self.menuItems addObject:dataDictionary];
        }
        
        NSLog(@"%@", self.menuItems);
        NSLog(@"Es tiempo de hacer reload en la tabla.");
        
        dispatch_async(dispatch_get_main_queue(), ^{
            [self.someCollectionView reloadData];
        });
    }
    
        
    
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (NSInteger)collectionView:(UICollectionView *)collectionView numberOfItemsInSection:(NSInteger)section
{
    return 2;
}

// The cell that is returned must be retrieved from a call to -dequeueReusableCellWithReuseIdentifier:forIndexPath:
- (UICollectionViewCell *)collectionView:(UICollectionView *)collectionView cellForItemAtIndexPath:(NSIndexPath *)indexPath;
{
    UICollectionViewCell *cell= [collectionView dequeueReusableCellWithReuseIdentifier:@"Cell" forIndexPath:indexPath];
    
    UIImageView *imageView = (UIImageView *) [cell viewWithTag:10];
    
    if ([self.menuItems count]>0){
        NSDictionary *cellDictionary = [self.menuItems objectAtIndex:indexPath.row];
        NSString *imageUrlString =[cellDictionary objectForKey:@"image_url"];
        NSLog(@"url de la imagen: %@",imageUrlString);
        NSURL *imageUrl = [NSURL URLWithString:imageUrlString];
        NSURLRequest *imageUrlRequest = [NSURLRequest requestWithURL:imageUrl];
        NSURLSessionDataTask *task =[self.session dataTaskWithRequest:imageUrlRequest completionHandler:^(NSData *data, NSURLResponse *response, NSError *error) {
            NSHTTPURLResponse *urlResponse = (NSHTTPURLResponse*) response;
            if (urlResponse.statusCode==200){
                NSLog(@"todo ok con la imagen");
                dispatch_async(dispatch_get_main_queue(), ^{
                    imageView.image=[UIImage imageWithData:data];
                });
               
            } else {
                NSLog(@"paso algo..");
            }
            //[self handleResult:data];
        }];
        [task resume];
        
        
    }
    return cell;
    
}

@end
