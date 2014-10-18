#!/home/utils/perl-5.8.8/bin/perl

use strict;
use warnings;

use File::Slurp qw(
    read_file
    write_file
);


sub filter_file{
    my $file = shift;

    `p4 edit $file`;
    my @file_array = read_file($file);
    $_ =~ s/-m rel5// for(@file_array);
    write_file($file, @file_array) ;

}

print "@ARGV";
