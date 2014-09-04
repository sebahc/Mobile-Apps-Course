//
//  Card.h
//  Matchismo
//


#import <Foundation/Foundation.h>

@interface Card : NSObject

@property(strong,nonatomic) NSString *contents;

@property(nonatomic,getter = isChosen) BOOL choosen;
@property(nonatomic,getter = isMatched) BOOL matched;

- (int)match:(NSArray *)otherCards;


@end
