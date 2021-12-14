package com.example.dynamicitemlazycolumn


val payloadOne = """
{
   "listItems":[
      {
         "type":"ROW",
         "listItems":[
            {
                "type":"COLUMN",
                "listItems":[
                   {
                      "type":"TEXT",
                      "message":"Mr. Handsome",
                      "backgroundColor":"RED",
                      "textFont":"BIG"
                   },
                   {
                      "type":"TEXT",
                      "message":"123, Some Street\nSome Suburb, 2001\nCity",
                      "backgroundColor":"GREEN"
                   },
                   {
                      "type":"BUTTON",
                      "message":"CALL 0123-456-789"
                   }
                ],
                "weight":"2.0"
            },
            {
                "type":"IMAGE",
                "backgroundColor":"BLUE",
                "weight":"1.0"
            }      
         ],
         "alignment":"FILL"
      }
   ]
}
""".trimIndent()

val payloadExpandable = """
{
   "listItems":[
      {
         "type":"ROW",
         "listItems":[
            {
               "type":"COLUMN",
               "listItems":[
                  {
                     "type":"TEXT",
                     "message":"Mr Charming",
                     "textAlign":"CENTER",
                     "textFont":"HUGE",
                     "alignment":"START",
                     "backgroundColor":"RED",
                     "weight":0.0
                  },
                  {
                     "type":"TEXT",
                     "message":"10001 Some Nice Road\nGreat Suburb 1234\nHeaven",
                     "textAlign":"START",
                     "textFont":"DEFAULT",
                     "alignment":"START",
                     "weight":0.0
                  }
               ],
               "alignment":"FILL",
               "weight":1.0
            },
            {
               "type":"IMAGE",
               "imageAlign":"CENTER",
               "alignment":"END",
               "backgroundColor":"GREEN",
               "weight":0.0
            }
         ],
         "alignment":"CENTER",
         "weight":0.0
      },
      {
         "type":"EXPANDABLE",
         "message":"Hello",
         "listItems":[
            {
                 "type":"ROW",
                 "listItems":[
                    {
                        "type":"COLUMN",
                        "listItems":[
                           {
                              "type":"TEXT",
                              "message":"Mr. Handsome",
                              "backgroundColor":"RED",
                              "textFont":"BIG"
                           },
                           {
                              "type":"TEXT",
                              "message":"123, Some Street\nSome Suburb, 2001\nCity",
                              "backgroundColor":"GREEN"
                           },
                           {
                              "type":"BUTTON",
                              "message":"CALL 0123-456-789"
                           }
                        ],
                        "weight":"2.0"
                    },
                    {
                        "type":"IMAGE",
                        "backgroundColor":"BLUE",
                        "weight":"1.0"
                    }      
                 ],
                 "alignment":"FILL"
            }
         ]
      },


      {
         "type":"COLUMN",
         "listItems": [
            {
                 "type":"TEXT",
                 "message":"Some expandable below",
                 "backgroundColor":"GREEN"
            },
            {
                 "type":"EXPANDABLE",
                 "message":"Hello there",
                 "listItems":[
                    {
                         "type":"ROW",
                         "listItems":[
                            {
                                "type":"COLUMN",
                                "listItems":[
                                   {
                                      "type":"TEXT",
                                      "message":"Mr. Handsome",
                                      "backgroundColor":"RED",
                                      "textFont":"BIG"
                                   },
                                   {
                                      "type":"TEXT",
                                      "message":"123, Some Street\nSome Suburb, 2001\nCity",
                                      "backgroundColor":"GREEN"
                                   },
                                   {
                                      "type":"BUTTON",
                                      "message":"CALL 0123-456-789"
                                   }
                                ],
                                "weight":"2.0"
                            },
                            {
                                "type":"IMAGE",
                                "backgroundColor":"BLUE",
                                "weight":"1.0"
                            }      
                         ],
                         "alignment":"FILL"
                    }
                 ]
            
            },
            {
                 "type":"TEXT",
                 "message":"Some expandable above",
                 "backgroundColor":"GREEN"
            }
         ]
      },



      {
         "type":"ROW",
         "listItems":[
            {
               "type":"IMAGE",
               "imageAlign":"CENTER",
               "alignment":"END",
               "weight":0.0
            },
            {
               "type":"COLUMN",
               "listItems":[
                  {
                     "type":"TEXT",
                     "message":"Mr Smart",
                     "textAlign":"CENTER",
                     "textFont":"HUGE",
                     "alignment":"START",
                     "weight":0.0
                  },
                  {
                     "type":"TEXT",
                     "message":"10001 Some Nice Road\nGreat Suburb 1234\nHeaven",
                     "textAlign":"START",
                     "textFont":"DEFAULT",
                     "alignment":"START",
                     "weight":0.0
                  }
               ],
               "alignment":"FILL",
               "weight":1.0
            }
         ],
         "alignment":"CENTER",
         "weight":0.0
      },
      {
         "type":"ROW",
         "listItems":[
            {
               "type":"IMAGE",
               "imageAlign":"CENTER",
               "alignment":"END",
               "weight":0.0
            },
            {
               "type":"COLUMN",
               "listItems":[
                  {
                     "type":"TEXT",
                     "message":"Mr Handsome",
                     "textAlign":"CENTER",
                     "textFont":"HUGE",
                     "alignment":"CENTER",
                     "backgroundColor":"BLUE",
                     "weight":0.0
                  },
                  {
                     "type":"TEXT",
                     "message":"10001 Some Nice Road\nGreat Suburb 1234\nHeaven",
                     "textAlign":"CENTER",
                     "textFont":"DEFAULT",
                     "alignment":"CENTER",
                     "weight":0.0
                  }
               ],
               "alignment":"FILL",
               "weight":1.0
            }
         ],
         "alignment":"CENTER",
         "weight":0.0
      }     
   ]
}
""".trimIndent()

val payloadMany = """
{
   "listItems":[
      {
         "type":"TEXT",
         "message":"Dyno Text",
         "textAlign":"CENTER",
         "textFont":"DEFAULT",
         "alignment":"CENTER",
         "weight":0.0
      },
      {
         "type":"TEXT",
         "message":"Dyno Text",
         "textAlign":"CENTER",
         "textFont":"DEFAULT",
         "alignment":"START",
         "weight":0.0
      },
      {
         "type":"TEXT",
         "message":"Dyno Text",
         "textAlign":"CENTER",
         "textFont":"DEFAULT",
         "alignment":"END",
         "weight":0.0
      },
      {
         "type":"BUTTON",
         "message":"Dyno Button",
         "alignment":"CENTER",
         "weight":0.0
      },
      {
         "type":"BUTTON",
         "message":"Dyno Button",
         "alignment":"START",
         "weight":0.0
      },
      {
         "type":"BUTTON",
         "message":"Dyno Button",
         "alignment":"END",
         "weight":0.0
      },
      {
         "type":"IMAGE",
         "imageAlign":"CENTER",
         "alignment":"CENTER",
         "weight":0.0
      },
      {
         "type":"IMAGE",
         "imageAlign":"CENTER",
         "alignment":"START",
         "weight":0.0
      },
      {
         "type":"IMAGE",
         "imageAlign":"CENTER",
         "alignment":"END",
         "weight":0.0
      },
      {
         "type":"COLUMN",
         "listItems":[
            {
               "type":"TEXT",
               "message":"Column Dyno Text",
               "textAlign":"CENTER",
               "textFont":"DEFAULT",
               "alignment":"CENTER",
               "weight":0.0
            },
            {
               "type":"IMAGE",
               "imageAlign":"CENTER",
               "alignment":"CENTER",
               "weight":0.0
            }
         ],
         "alignment":"CENTER",
         "weight":0.0
      },
      {
         "type":"COLUMN",
         "listItems":[
            {
               "type":"TEXT",
               "message":"Column Dyno Text Start",
               "textAlign":"CENTER",
               "textFont":"DEFAULT",
               "alignment":"START",
               "weight":0.0
            },
            {
               "type":"IMAGE",
               "imageAlign":"CENTER",
               "alignment":"CENTER",
               "weight":0.0
            },
            {
               "type":"TEXT",
               "message":"Column Dyno Text End",
               "textAlign":"CENTER",
               "textFont":"DEFAULT",
               "alignment":"END",
               "weight":0.0
            }
         ],
         "alignment":"FILL",
         "weight":0.0
      },
      {
         "type":"ROW",
         "listItems":[
            {
               "type":"TEXT",
               "message":"Hello Dyno Text",
               "textAlign":"CENTER",
               "textFont":"DEFAULT",
               "alignment":"CENTER",
               "weight":1.0
            },
            {
               "type":"IMAGE",
               "imageAlign":"CENTER",
               "alignment":"CENTER",
               "weight":1.0
            }
         ],
         "alignment":"CENTER",
         "weight":0.0
      },
      {
         "type":"ROW",
         "listItems":[
            {
               "type":"TEXT",
               "message":"Hello Dyno Text",
               "textAlign":"START",
               "textFont":"DEFAULT",
               "alignment":"CENTER",
               "weight":1.0
            },
            {
               "type":"IMAGE",
               "imageAlign":"END",
               "alignment":"CENTER",
               "weight":1.0
            }
         ],
         "alignment":"CENTER",
         "weight":0.0
      },
      {
         "type":"ROW",
         "listItems":[
            {
               "type":"TEXT",
               "message":"Hello Dyno Text",
               "textAlign":"END",
               "textFont":"DEFAULT",
               "alignment":"CENTER",
               "weight":1.0
            },
            {
               "type":"IMAGE",
               "imageAlign":"START",
               "alignment":"CENTER",
               "weight":1.0
            }
         ],
         "alignment":"CENTER",
         "weight":0.0
      },
      {
         "type":"ROW",
         "listItems":[
            {
               "type":"TEXT",
               "message":"Row Start",
               "textAlign":"START",
               "textFont":"SMALL",
               "alignment":"CENTER",
               "weight":1.0
            },
            {
               "type":"IMAGE",
               "imageAlign":"CENTER",
               "alignment":"CENTER",
               "weight":1.0
            },
            {
               "type":"TEXT",
               "message":"Row End",
               "textAlign":"END",
               "textFont":"DEFAULT",
               "alignment":"CENTER",
               "weight":1.0
            }
         ],
         "alignment":"CENTER",
         "weight":0.0
      },
      {
         "type":"COLUMN",
         "listItems":[
            {
               "type":"ROW",
               "listItems":[
                  {
                     "type":"TEXT",
                     "message":"Row Dyno Text",
                     "textAlign":"CENTER",
                     "textFont":"DEFAULT",
                     "alignment":"CENTER",
                     "weight":0.0
                  },
                  {
                     "type":"IMAGE",
                     "imageAlign":"CENTER",
                     "alignment":"CENTER",
                     "weight":0.0
                  }
               ],
               "alignment":"CENTER",
               "weight":0.0
            },
            {
               "type":"IMAGE",
               "imageAlign":"CENTER",
               "alignment":"CENTER",
               "weight":0.0
            }
         ],
         "alignment":"CENTER",
         "weight":0.0
      },
      {
         "type":"COLUMN",
         "listItems":[
            {
               "type":"IMAGE",
               "imageAlign":"CENTER",
               "alignment":"CENTER",
               "weight":0.0
            },
            {
               "type":"ROW",
               "listItems":[
                  {
                     "type":"TEXT",
                     "message":"Row Dyno Text",
                     "textAlign":"CENTER",
                     "textFont":"DEFAULT",
                     "alignment":"CENTER",
                     "weight":0.0
                  },
                  {
                     "type":"IMAGE",
                     "imageAlign":"CENTER",
                     "alignment":"END",
                     "weight":0.0
                  }
               ],
               "alignment":"CENTER",
               "weight":0.0
            }
         ],
         "alignment":"CENTER",
         "weight":0.0
      },
      {
         "type":"ROW",
         "listItems":[
            {
               "type":"TEXT",
               "message":"Row Dyno Text",
               "textAlign":"CENTER",
               "textFont":"DEFAULT",
               "alignment":"CENTER",
               "weight":1.0
            },
            {
               "type":"COLUMN",
               "listItems":[
                  {
                     "type":"TEXT",
                     "message":"Column Dyno Text",
                     "textAlign":"CENTER",
                     "textFont":"DEFAULT",
                     "alignment":"CENTER",
                     "weight":0.0
                  },
                  {
                     "type":"IMAGE",
                     "imageAlign":"CENTER",
                     "alignment":"END",
                     "weight":0.0
                  }
               ],
               "alignment":"CENTER",
               "weight":1.0
            }
         ],
         "alignment":"CENTER",
         "weight":0.0
      },
      {
         "type":"ROW",
         "listItems":[
            {
               "type":"COLUMN",
               "listItems":[
                  {
                     "type":"TEXT",
                     "message":"Column Dyno Text",
                     "textAlign":"CENTER",
                     "textFont":"DEFAULT",
                     "alignment":"CENTER",
                     "weight":0.0
                  },
                  {
                     "type":"IMAGE",
                     "imageAlign":"CENTER",
                     "alignment":"CENTER",
                     "weight":0.0
                  }
               ],
               "alignment":"CENTER",
               "weight":0.0
            },
            {
               "type":"TEXT",
               "message":"Row Dyno Text",
               "textAlign":"CENTER",
               "textFont":"DEFAULT",
               "alignment":"CENTER",
               "weight":0.0
            }
         ],
         "alignment":"CENTER",
         "weight":0.0
      },
     {
         "type":"ROW",
         "listItems":[
            {
               "type":"COLUMN",
               "listItems":[
                  {
                     "type":"TEXT",
                     "message":"Mr Charming",
                     "textAlign":"CENTER",
                     "textFont":"HUGE",
                     "alignment":"START",
                     "backgroundColor":"RED",
                     "weight":0.0
                  },
                  {
                     "type":"TEXT",
                     "message":"10001 Some Nice Road\nGreat Suburb 1234\nHeaven",
                     "textAlign":"START",
                     "textFont":"DEFAULT",
                     "alignment":"START",
                     "weight":0.0
                  }
               ],
               "alignment":"FILL",
               "weight":1.0
            },
            {
               "type":"IMAGE",
               "imageAlign":"CENTER",
               "alignment":"END",
               "backgroundColor":"GREEN",
               "weight":0.0
            }
         ],
         "alignment":"CENTER",
         "weight":0.0
      },
      {
         "type":"ROW",
         "listItems":[
            {
               "type":"IMAGE",
               "imageAlign":"CENTER",
               "alignment":"END",
               "weight":0.0
            },
            {
               "type":"COLUMN",
               "listItems":[
                  {
                     "type":"TEXT",
                     "message":"Mr Smart",
                     "textAlign":"CENTER",
                     "textFont":"HUGE",
                     "alignment":"START",
                     "weight":0.0
                  },
                  {
                     "type":"TEXT",
                     "message":"10001 Some Nice Road\nGreat Suburb 1234\nHeaven",
                     "textAlign":"START",
                     "textFont":"DEFAULT",
                     "alignment":"START",
                     "weight":0.0
                  }
               ],
               "alignment":"FILL",
               "weight":1.0
            }
         ],
         "alignment":"CENTER",
         "weight":0.0
      },
      {
         "type":"ROW",
         "listItems":[
            {
               "type":"IMAGE",
               "imageAlign":"CENTER",
               "alignment":"END",
               "weight":0.0
            },
            {
               "type":"COLUMN",
               "listItems":[
                  {
                     "type":"TEXT",
                     "message":"Mr Handsome",
                     "textAlign":"CENTER",
                     "textFont":"HUGE",
                     "alignment":"CENTER",
                     "backgroundColor":"BLUE",
                     "weight":0.0
                  },
                  {
                     "type":"TEXT",
                     "message":"10001 Some Nice Road\nGreat Suburb 1234\nHeaven",
                     "textAlign":"CENTER",
                     "textFont":"DEFAULT",
                     "alignment":"CENTER",
                     "weight":0.0
                  }
               ],
               "alignment":"FILL",
               "weight":1.0
            }
         ],
         "alignment":"CENTER",
         "weight":0.0
      }      
   ]
}    
""".trimIndent()