#!/usr/bin/perl
use strict;
use warnings;

my $hash = {};
sub match
{
    my $str = shift;

    _add(split(/</,$str));

}

sub _add{
    my @str = @_;

    foreach my $s (@str){
        if($s =~ /^[a-z|0-9]+/){

            if($s =~ /([a-z|0-9]+)+\s/s){
                my $tag = $1;
                foreach my $attr ($s =~ /\s([a-z|0-9]+)+=/sg){
                    $hash->{$tag}->{$attr} = '';
                }
            }

            if($s =~ /([a-z|0-9]+)+>+/s){
                $hash->{$1} = '';
            }
        }
    }
}

sub print_all{

    foreach my $key1 (sort keys %{$hash}){
        print "$key1:";
        if(ref($hash->{$key1})){
            my $i = 0;
            foreach my $key2 (sort keys %{$hash->{$key1}}){
                if($i){
                    print ",$key2";
                } else{
                    print $key2;
                }
                $i++;
            }
        }
        print "\n";
    }
}

# Tail starts here
my $testcases = <>;
for (1..$testcases){
    my $str = <>;
    chomp($str);
    match($str);
}

print_all();